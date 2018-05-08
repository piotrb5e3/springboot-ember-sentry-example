# springboot-ember-sentry-example
Example project for a demo

It contains intentional bugs to show how they appear when reported to sentry

# Requirements
* Java 8 (preferably openjdk)
* Node (tested on v8.11.1)
* Yarn
* Ember.js
* Apache
* Docker 1.10.0+
* Docker Compose 1.6.0+
* Sudo powers

# Setting up sentry
* Clone https://github.com/getsentry/onpremise
* Follow the "Up and Running" instructions in its README
* Navigate to `localhost:9000` and finish the setup
* Create new project `Demo`
* Navigate to Project Settings > Client Keys (DSN)
* Click expand
* Here are your private and public DSNs

# Setting up apache
* Enable `mod_proxy` and `mod_proxy_http` 
* Add the following vhost to your apache configuration:
```
<VirtualHost *:80>
    ServerName sentrydemo.localhost
    ProxyRequests off
    <Location /api>
    	ProxyPass "http://localhost:8080/api"
    </Location>
    <LocationMatch "^/(?!api)">
    	ProxyPass "http://localhost:4200"
    	ProxyPassReverse "http://localhost:4200"
    </LocationMatch>
    ProxyPassReverse "/" "http://localhost:8080"
</VirtualHost>
```
* Add the following line to `/etc/hosts`:
```
127.0.0.1       sentrydemo.localhost
```

# Setting up the demo
* Clone this repository

## Frontend
* Navigate to the frontend directory
* Copy `config/environment.js.template` to `config/environment.js`
* Replace `YOUR_PUBLIC_DSN` in `config/environment.js` with value from the Sentry Project Settings page
* Run `yarn install`
* Run `ember s`

## Backend
* In a separate terminal navigate to the backend directory
* Copy `config/application.yml.template` to `config/application.yml`
* Replace `YOUR_PRIVATE_DSN` in `config/application.yml` with value from the Sentry Project Settings page
* Run `./gradlew bootRun`

# Demo scenario
* Navigate to `http://sentrydemo.localhost` in a browser
* Input any city name into the city name input
* Select "Open Weather Maps" from data source dropdown and press "Get weather"
* No error should appear
* Select "Accuweather" from data source dropdown and press "Get weather"
* Examine error in sentry:
  * Navigate to `http://localhost:9000` in a separate window
  * Select project "Demo" from list
  * 2 errors should be visible - one from the frontend and one from the backend
  * Examine each. Note detailed breadcrumbs in frontend error
* Press "Login" at the top of the page
* Input `user` as the username and `password` as password
* Press Login, you will be redirected to the weather info page
* Select "Accuweather" from data source dropdown and press "Get weather"
* Examine error in sentry. Note the user information added to the backend error report
* Refresh the weather page (press F5)
* Do not select the weather source, input the city name and press "Get weather"
* Examine the frontend-only error in sentry
* The stacktrace can be improved by uploading sourcemaps