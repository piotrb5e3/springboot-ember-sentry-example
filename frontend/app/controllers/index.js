import Ember from 'ember';
import { inject as service } from '@ember/service';

export default Ember.Controller.extend({
  weatherResponse: null,
  selectedSource: null,
  sources: [
    {code: 'OWM', name: 'Open Weather Maps'},
    {code: 'ACCW', name: 'Accuweather'}
  ],
  cityName: '',
  weather: service(),
  err: '',

  actions: {
    getWeather() {
      this.set('err', '');
      const source = this.get('selectedSource');
      const cityName = this.get('cityName');
      this.get('weather').getWeather(source, cityName).then(result => {
        this.set('weatherResponse', result);
      });
    }
  }
});
