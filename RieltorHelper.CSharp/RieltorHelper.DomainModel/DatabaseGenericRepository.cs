using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Linq.Expressions;
using System.Threading.Tasks;

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

        public Task<int> GetCountAsync()
        {
            return Task<int>.Factory.StartNew(() => GetCount());
        }

        public Task<IQueryable<T>> GetAsync()
        {
            return Task<IQueryable<T>>.Factory.StartNew(() => Get());
        }

        public Task<IQueryable<T>> GetAsync(Expression<Func<T, bool>> query)
        {
            return Task<IQueryable<T>>.Factory.StartNew(() => Get(query));
        }

        public Task<T> GetAsync(int id)
        {
            return Task<T>.Factory.StartNew(() => Get(id));
        }

        public Task CreateAsync(T value)
        {
            return Task.Factory.StartNew(() => Create(value));
        }

        public Task EditAsync(int id, T value)
        {
            return Task.Factory.StartNew(() => Edit(id, value));
        }

        public Task DeleteAsync(int id)
        {
            return Task.Factory.StartNew(() => Delete(id));
        }
    }
}
