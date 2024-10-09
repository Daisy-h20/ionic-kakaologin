import { registerPlugin } from '@capacitor/core';

import type { kakaoLoginPlugin } from './definitions';

const kakaoLogin = registerPlugin<kakaoLoginPlugin>('kakaoLogin', {
  web: () => import('./web').then(m => new m.kakaoLoginWeb()),
});

export * from './definitions';
export { kakaoLogin };
