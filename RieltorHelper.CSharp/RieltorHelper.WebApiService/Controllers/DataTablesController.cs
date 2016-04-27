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
        
        [HttpGet]
        public int GetDataTablesCount()
        {
            
        }
        
        [HttpGet] 
        public IEnumerable<IDataTable> GetDataTables(int offset, int count)
        {
            
        }
        
        [HttpGet]
        public IDataTable GetDataTable(int id)
        {
            
        }
        
        [HttpPost]
        public void CreateDataTable(IDataTable value)
        {
            
        }
        
        [HttpPut]
        void EditDataTable(int id, IDataTable value)
        {
            
        }
        
        [HttpDelete]
        public void RemoveDataTable(int id)
        {
            
        }
    }    
}