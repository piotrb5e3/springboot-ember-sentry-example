import Ember from 'ember';
import { inject as service } from '@ember/service';

export default Ember.Controller.extend({
  session: service(),
  username: '',
  password: '',
  errorMessage: '',
  actions: {
    tryAuthenticate() {
      const { username, password } = this.getProperties('username', 'password');
      this.get('session').authenticate(
        'authenticator:simple', username, password
      ).then(() => this.transitionToRoute('index')).catch((reason) => {
        this.set('errorMessage', reason.error || reason);
      });

    }
  }
});
