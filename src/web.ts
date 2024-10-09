import { WebPlugin } from '@capacitor/core';

import type { kakaoLoginPlugin } from './definitions';

export class kakaoLoginWeb extends WebPlugin implements kakaoLoginPlugin {
  kakaoLogin(_options: { appKey: string }): Promise<{ email: string }> {
    throw new Error('Method not implemented.');
  }
}
