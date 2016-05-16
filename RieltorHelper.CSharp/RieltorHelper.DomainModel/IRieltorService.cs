using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;

namespace RieltorHelper.DomainModel
{
    public interface IRieltorService: IDisposable
    {
        IEnumerable<User> GetUsers(Expression<Func<User, bool>> predicate);
        IEnumerable<User> GetUsers();
        void CreateUser(User value);
    }
}
