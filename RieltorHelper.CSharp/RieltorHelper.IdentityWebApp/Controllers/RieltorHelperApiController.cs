using RieltorHelper.DomainModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web.Http;

namespace RieltorHelper.IdentityWebApp.Controllers
{
    [RoutePrefix("api/v1")] //prefix to all method routes in this class
    public class RieltorHelperApiController: ApiController
    {
        private IRieltorService service;
        
        public RieltorHelperApiController(IRieltorService service)
        {
            this.service = service;

        }

        /// <summary>
        /// Get list of users satisfying the fio parameter
        /// </summary>
        /// <param name="access_token"> Access token of the application</param>
        /// <param name="fio"> Value for fio </param>
        /// <returns>IEnumerable of users</returns>
        [Route("users/get")] //this route is equal to http://<address>/api/v1/get?fio=____
        [HttpGet]
        [Authorize]
        public IEnumerable<User> GetUsers(string access_token, string fio = "")
        {
            if (fio != "")
            {
                return service.GetUsers(usr => usr.FIO.ToUpper().Contains(fio.ToUpper()));
            }
            else
            {
                return service.GetUsers();
            }
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