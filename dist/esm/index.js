import { registerPlugin } from '@capacitor/core';
const kakaoLogin = registerPlugin('kakaoLogin', {
    web: () => import('./web').then(m => new m.kakaoLoginWeb()),
});
export * from './definitions';
export { kakaoLogin };
//# sourceMappingURL=index.js.map