export interface kakaoLoginPlugin {
  kakaoLogin(options: { appKey: string }): Promise<{ email: string }>;
}
