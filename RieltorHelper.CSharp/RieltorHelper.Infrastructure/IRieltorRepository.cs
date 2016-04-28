using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorRepository<T> where T: class
    {
        int GetTablesCount();
        IEnumerable<T> GetTables(int offset, int count);
        T GetTable(int id);
        void CreateTable(T table);
        void EditTable(int id, T table);
        void DeleteTable(int id);
    }
}
