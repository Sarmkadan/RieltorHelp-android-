using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorRepository<T> where T: class
    {
        int GetCount();
        IEnumerable<T> Get();
        IEnumerable<T> GetQueried(Func<T, bool> query);
        T Get(int id);
        void Create(T value);
        void Edit(int id, T value);
        void Delete(int id);
    }
}
