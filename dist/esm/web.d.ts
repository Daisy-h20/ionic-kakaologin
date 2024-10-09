import { WebPlugin } from '@capacitor/core';
import type { kakaoLoginPlugin } from './definitions';
export declare class kakaoLoginWeb extends WebPlugin implements kakaoLoginPlugin {
    kakaoLogin(_options: {
        appKey: string;
    }): Promise<{
        email: string;
    }>;
}
