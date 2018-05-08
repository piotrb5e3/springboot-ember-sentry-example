import Base from 'ember-simple-auth/authenticators/base';

import { inject as service } from '@ember/service';

const BASE_URL = 'http://sentrydemo.localhost/api';
const LOGIN_URL = `${BASE_URL}/login`;
const LOGOUT_URL = `${BASE_URL}/logout`;

export default Base.extend({
  ajax: service(),
restore(/* data */) {
    return false;
  },
  authenticate(username, password) {
    return this.get('ajax').post(LOGIN_URL, {
      data: {
        username,
        password,
      },
      dataType : 'html',
    })
  },
  invalidate(/* data */) {
    return this.get('ajax').post(LOGOUT_URL);
  }
});
