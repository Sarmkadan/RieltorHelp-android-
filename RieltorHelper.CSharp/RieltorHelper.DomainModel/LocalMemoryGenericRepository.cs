using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;

namespace RieltorHelper.DomainModel
{
    public class LocalMemoryGenericRepository<T> : IGenericRepository<T> where T : class, IDatabaseEntity
    {
        private List<T> entities;

        public LocalMemoryGenericRepository()
        {
            entities = new List<T>();
        }

        public void Create(T value)
        {
            entities.Add(value);
        }

        public void Delete(int id)
        {
            throw new NotImplementedException();
        }

        public void Edit(int id, T value)
        {
            throw new NotImplementedException();
        }

        public IQueryable<T> Get()
        {
            return entities.AsQueryable();
        }

        public T Get(int id)
        {
            return entities.First(e => e.Id == id);
        }

        public IQueryable<T> Get(Expression<Func<T, bool>> query)
        {
            return entities.AsQueryable().Where(query);
        }

        public int GetCount()
        {
            return entities.Count;
        }
    }
}
