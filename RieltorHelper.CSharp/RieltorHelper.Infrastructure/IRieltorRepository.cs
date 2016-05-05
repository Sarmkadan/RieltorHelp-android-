using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorRepository<T> where T: class
    {
        int GetCount();
        IEnumerable<T> GetAll(int offset, int count);
        T Get(int id);
        void Create(T value);
        void Edit(int id, T value);
        void Delete(int id);
    }
}
