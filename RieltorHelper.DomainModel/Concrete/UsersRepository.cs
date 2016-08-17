using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace RieltorHelper.DomainModel
{
    public class UsersRepository : IGenericRepository<User>
    {
        RieltorDbContext dbContext;
        public UsersRepository()
        {
            dbContext = new RieltorDbContext();
        }

        public IQueryable<User> AsQueryable()
        {
            return dbContext.Users.AsQueryable();
        }

        public void Create(User value)
        {
            throw new NotImplementedException();
        }

        public Task CreateAsync(User value)
        {
            throw new NotImplementedException();
        }

        public void Delete(int id)
        {
            throw new NotImplementedException();
        }

        public Task DeleteAsync(int id)
        {
            throw new NotImplementedException();
        }

        public void Edit(int id, User value)
        {
            throw new NotImplementedException();
        }

        public Task EditAsync(int id, User value)
        {
            throw new NotImplementedException();
        }

        public IQueryable<User> Get()
        {
            return dbContext.Users;
        }

        public User Get(int id)
        {
            return dbContext.Users.Find(id);
        }

        public IQueryable<User> Get(Expression<Func<User, bool>> query)
        {
            throw new NotImplementedException();
        }

        public Task<IQueryable<User>> GetAsync()
        {
            throw new NotImplementedException();
        }

        public Task<User> GetAsync(int id)
        {
            throw new NotImplementedException();
        }

        public Task<IQueryable<User>> GetAsync(Expression<Func<User, bool>> query)
        {
            throw new NotImplementedException();
        }

        public int GetCount()
        {
            throw new NotImplementedException();
        }

        public Task<int> GetCountAsync()
        {
            throw new NotImplementedException();
        }
    }
}
