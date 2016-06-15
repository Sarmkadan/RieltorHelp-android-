using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace RieltorHelper.DomainModel
{
    public interface IRieltorService: IDisposable
    {
        IQueryable<User> GetUsers(Expression<Func<User, bool>> predicate);
        Task<IQueryable<User>> GetUsersAsync(Expression<Func<User, bool>> predicate);
        IQueryable<User> GetUsers();
        Task<IQueryable<User>> GetUsersAsync();
        void CreateUser(User value);
        Task CreateUserAsync(User value);
    }
}
