import Ember from 'ember';
import { inject as service } from '@ember/service';

const API_URL = 'http://sentrydemo.localhost/api';

const ENDPOINT_URL = `${API_URL}/getWeather`;

export default Ember.Service.extend({
  ajax: service(),
  getWeather(source, cityName) {
    return this.get('ajax').request(ENDPOINT_URL, {
      data: {
          dataSourceCode: source.code,
          cityName: cityName,
      },
      xhrFields: {
        withCredentials: true
     },
    });
  }
});
