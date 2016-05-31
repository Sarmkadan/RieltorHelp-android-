using RieltorHelper.DomainModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

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

        public void Dispose()
        {
            unitOfWork.Dispose();
        }

        public IQueryable<User> GetUsers(Expression<Func<User, bool>> predicate)
        {
            return userRepo.Get(predicate);
        }

        public Task<IQueryable<User>> GetUsersAsync(Expression<Func<User, bool>> predicate)
        {
            return userRepo.GetAsync(predicate);
        }

        public IQueryable<User> GetUsers()
        {
            return userRepo.Get();
        }

        public Task<IQueryable<User>> GetUsersAsync()
        {
            return userRepo.GetAsync();
        }

        public void CreateUser(User value)
        {
            userRepo.Create(value);
        }


        public Task CreateUserAsync(User value)
        {
            return userRepo.CreateAsync(value);
        }
    }
}
