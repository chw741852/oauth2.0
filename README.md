## OAuth2.0
1. Start authorization
2. Access `http://localhost:8080/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://baidu.com` in browser and get the code from redirect link like `https://www.baidu.com/?code=cj2rRI`
3. Get token from postman.
    * Post 'http://localhost:8080/oauth/token?grant_type=authorization_code&code=cj2rRI&client_id=client&client_secret=123456&redirect_uri=http://baidu.com&scope=test'
    * Get access_token from the returned
4. Access `http://localhost:8080/user?access_token={Access_Token}` or add a header like `Authorization: Bearer {Access_Token}`
5. Start resource1 and access `http://localhost:8081/user` like step 4

