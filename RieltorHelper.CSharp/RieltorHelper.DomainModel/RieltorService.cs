using RieltorHelper.DomainModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;

namespace RieltorHelper.DomainModel
{
    public class RieltorService : IRieltorService
    {
        IUnitOfWork unitOfWork;
        IGenericRepository<User> userRepo;

        public RieltorService(IUnitOfWork unitOfWork, IGenericRepository<User> userRepo)
        {
            this.unitOfWork = unitOfWork;
            this.userRepo = userRepo;
        }

        public IEnumerable<User> GetUsers()
        {
            return userRepo.Get();
        }

        public IEnumerable<User> GetUsers(Expression<Func<User, bool>> predicate)
        {
            return userRepo.Get(predicate);
        }

        public void CreateUser(User value)
        {
            userRepo.Create(value);
        }

        public void Dispose()
        {
            unitOfWork.Dispose();
        }

    }
}
