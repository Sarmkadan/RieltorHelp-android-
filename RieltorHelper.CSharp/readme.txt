ASP.NET WebApi application

Work with MsSql database over the Entity Framework ORM.

Before execute configure the connectionString (Web.config file <connectionstrings> xml-node)

To create account:
POST /api/Register
Body:
{
  "Email": "sample string 1",
  "Password": "sample string 2",
  "ConfirmPassword": "sample string 2"
}

To get access_token:
POST /Token
Body:
grant_type=password&username=<UserName>&password=<Password>

access_token will be in response body.

To interact with API methods include access_token to query string (1) of request header (2):
1. <request>?access_token=<Token>
2. Authorization: Bearer <Token>