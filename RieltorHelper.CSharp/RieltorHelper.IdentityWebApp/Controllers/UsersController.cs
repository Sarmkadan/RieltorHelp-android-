using RieltorHelper.DomainModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.OData;
using System.Web.Http.OData.Query;
using System.Net.Http;
using System.Web.Http.OData.Extensions;

namespace RieltorHelper.IdentityWebApp.Controllers
{
    //Uncomment this line to enable authorization
    //[Authorize]
    public class UsersController: ApiController
    {
        private IGenericRepository<User> repository;
        
        public UsersController(IGenericRepository<User> repository)
        {
            this.repository = repository;

        }

        /// <summary>
        /// Get list of users satisfying the fio parameter
        /// </summary>
        /// <param name="access_token"> Access token of the application</param>
        /// <returns>IEnumerable of users</returns>
        [HttpGet]
        [EnableQuery]
        public  IQueryable<User> Get(string access_token)
        {
            return repository.AsQueryable();
        }

        /*
        Build other API methods
        like
        
        [Route("<route>")]
        [<Http_method>]
        public <return_result> <Method_Name>(<parameters>)
        {
            return <return_result>;
        }
        
        where:
        <route> = Route template for this method. I.e. if Route attribute name parameter will be "value" then the total route will be http://<address+port>/api/v1/value
        <Http_method> = one of the Http methods: HttpGet, HttpPost, HttpPut, HttpDelete
        <parameters> = can be optional (string param_name="") or required (string param_name)
        return only for NON void methods
        */
    }    
}