using System;
using RieltorHelper.Infrastructure;
using RieltorHelper.DomainModel;

namespace RieltorHelper.WebApiService
{
    [Route('api/DataTables')]
    public class DataTablesController: ApiController, IRieltorService
    {
        IRieltorRepository repo;
        public DataTablesController(IRieltorRepository repo)
        {
            this.repo = repo;
        }
        
        [HttpGet]
        public int GetDataTablesCount()
        {
            repo.GetDataTablesCount();   
        }
        
        [HttpGet] 
        public IEnumerable<IDataTable> GetDataTables(int offset, int count)
        {
            repo.GetTables(offset, count);
        }
        
        [HttpGet]
        public IDataTable GetDataTable(int id)
        {
            repo.GetTable(id);
        }
        
        [HttpPost]
        public void CreateDataTable(IDataTable value)
        {
            repo.CreateTable(value);
        }
        
        [HttpPut]
        void EditDataTable(int id, IDataTable value)
        {
            repo.EditTable(id, value);
        }
        
        [HttpDelete]
        public void RemoveDataTable(int id)
        {
            repo.DeleteTable(id);   
        }
    }    
}