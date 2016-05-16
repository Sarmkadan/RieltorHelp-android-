using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Linq.Expressions;

namespace RieltorHelper.DomainModel
{
    public class DatabaseGenericRepository<T> : IGenericRepository<T> where T: class, IDatabaseEntity
    {
        protected RieltorDbContext _context;

        public DatabaseGenericRepository(IUnitOfWork unit)
        {
            _context = unit.dbContext;
        }

        public T Get(int id)
        {
            return _context.Set<T>().Find(id);
        }

        public IQueryable<T> Get(Expression<Func<T, bool>> query)
        {
            IQueryable<T> q = _context.Set<T>().Where(query);
            return q;
        }

        public IQueryable<T> Get()
        {
            return _context.Set<T>();
        }

        public void Create(T value)
        {
            _context.Set<T>().Add(value);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var userToDelete = _context.Users.Find(id);
            if (userToDelete != null)
            {
                _context.Users.Remove(userToDelete);
                _context.SaveChanges();
            }
        }

        public void Edit(int id, T value)
        {
            if (value.Id == id)
            {
                _context.Entry(value).State = System.Data.Entity.EntityState.Modified;
                _context.SaveChanges();
            }
        }

        public int GetCount()
        {
            return _context.Set<T>().Count();
        }

        
    }
}
