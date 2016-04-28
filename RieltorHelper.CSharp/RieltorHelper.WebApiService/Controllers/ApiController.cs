using System;
using RieltorHelper.Infrastructure;
using RieltorHelper.DomainModel;

namespace RieltorHelper.WebApiService
{
    [RoutePrefix('api/v1')] //prefix to all method routes in this class
    public class DataTablesController: ApiController, IRieltorService
    {
        IRieltorRepository repo;
        public DataTablesController(IRieltorRepository repo)
        {
            this.repo = repo;
        }
        
        [Route("some_method")] //this route is equal with http://<address>/api/v1/some_method
        [HttpGet]
        public IEnumerable<SomeData> Get(string some_param, string some_optionaly_param = "")
        {
            return new SomeData[] { new SomeData() };
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
        */
    }    
}