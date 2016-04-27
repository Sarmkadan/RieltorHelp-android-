using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorService
    {
        int GetDataTablesCount(); 
        IEnumerable<IDataTable> GetDataTables(int offset, int count);
        IDataTable GetDataTable(int id);
        void CreateDataTable(IDataTable value);
        void EditDataTable(int id, IDataTable value);
        void RemoveDataTable(int id);
    }
}
