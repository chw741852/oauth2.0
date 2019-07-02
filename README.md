## OAuth2.0
1. Start authorization
2. Start resource1

### Authorization Code
1. Access `http://localhost:8080/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://baidu.com` in browser and get the code from redirect link like `https://www.baidu.com/?code=cj2rRI`
2. Get token from postman.
    * Post 'http://localhost:8080/oauth/token?grant_type=authorization_code&code=cj2rRI&client_id=client&client_secret=123456&redirect_uri=http://baidu.com&scope=test'
    * Get access_token from the returned
3. Access `http://localhost:8080/user?access_token={Access_Token}` or add a header like `Authorization: Bearer {Access_Token}`

### Client Credential
1. POST `http://localhost:8080/oauth/token?grant_type=client_credentials&client_id=client&client_secret=123456`

### Password
1. POST `http://localhost:8080/oauth/token?grant_type=password&username=admin&password=admin&client_id=client&client_secret=123456&scope=test`

### Implicit
1. Access `http://localhost:8080/oauth/authorize?response_type=token&client_id=client&redirect_uri=http://baidu.com` in browser

### Refresh Token
1. POST `http://localhost:8080/oauth/token?client_id=client&client_secret=123456&grant_type=refresh_token&refresh_token={Refresh_Token}`

