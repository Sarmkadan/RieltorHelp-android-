using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorRepository
    {
        int GetTablesCount();
        IEnumerable<IDataTable> GetTables(int offset, int count);
        IDataTable GetTable(int id);
        void CreateTable(IDataTable table);
        void EditTable(int id, IDataTable table);
        void DeleteTable(int id);
    }
}
