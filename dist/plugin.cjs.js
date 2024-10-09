'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const kakaoLogin = core.registerPlugin('kakaoLogin', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.kakaoLoginWeb()),
});

class kakaoLoginWeb extends core.WebPlugin {
    kakaoLogin(_options) {
        throw new Error('Method not implemented.');
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    kakaoLoginWeb: kakaoLoginWeb
});

exports.kakaoLogin = kakaoLogin;
//# sourceMappingURL=plugin.cjs.js.map
