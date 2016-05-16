using RieltorHelper.DomainModel;
using RieltorHelper.Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web.Http;

namespace RieltorHelper.WebApiService
{
    [RoutePrefix("api/v1")] //prefix to all method routes in this class
    public class RieltorHelperApiController: ApiController
    {
        private UnitOfWork dbUbit;
        
        public RieltorHelperApiController()//IUnitOfWork dbUbit)
        {
            this.dbUbit = new UnitOfWork();//dbUbit;
            /*
            this.dbUbit.UserRepository.Create(new User() { Id = 1, FIO = "kos koska", About = "some user", Phone = 123 });
            this.dbUbit.UserRepository.Create(new User() { Id = 2, FIO = "some guy", About = "another user", Phone = 432});
            this.dbUbit.UserRepository.Create(new User() { Id = 3, FIO = "Arya Stark", About = "a girl has no name", Phone = 321 });*/
        }
        
        [Route("users/get")] //this route is equal to http://<address>/api/v1/get?fio=____
        [HttpGet]
        public IEnumerable<User> Get(string fio = "")
        {
            return dbUbit.UserRepository.GetQueried(usr => usr.FIO.ToUpper().Contains(fio.ToUpper()));
        }

        [Route("users/getall")] //this route is equal to http://<address>/api/v1/getAll
        [HttpGet]
        public IEnumerable<User> Get()
        {
            return dbUbit.UserRepository.Get();
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