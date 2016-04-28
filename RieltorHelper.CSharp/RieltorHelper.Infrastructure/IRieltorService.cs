using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorService<T, X> where T: IRieltorRepository<X> where X : class
    {
        int GetDataTablesCount(); 
        IEnumerable<T> GetDataTables(int offset, int count);
        T GetDataTable(int id);
        void CreateDataTable(T value);
        void EditDataTable(int id, T value);
        void RemoveDataTable(int id);
    }
}
