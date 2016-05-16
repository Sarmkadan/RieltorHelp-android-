using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IGenericRepository<T> where T: class
    {
        int GetCount();
        IQueryable<T> Get();
        IQueryable<T> Get(Expression<Func<T, bool>> query);
        T Get(int id);
        void Create(T value);
        void Edit(int id, T value);
        void Delete(int id);
    }
}
