using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorRepository
    {
        IEnumerable<IDataTable> GetTables();
        IDataTable GetTable(int id);
        void CreateTable(IDataTable table);
        void EditTable(int id, IDataTable table);
        void DeleteTable(int id);
    }
}
