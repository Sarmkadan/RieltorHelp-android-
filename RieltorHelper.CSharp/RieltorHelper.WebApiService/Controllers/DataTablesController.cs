using System;
using RieltorHelper.Infrastructure;
using RieltorHelper.DomainModel;

namespace RieltorHelper.WebApiService
{
    [Route('api/DataTables')]
    public class DataTablesController: ApiController
    {
        IRieltorRepository repo;
        public DataTablesController(IRieltorRepository repo)
        {
            this.repo = repo;
        }
    }    
}