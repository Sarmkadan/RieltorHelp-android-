using RieltorHelper.Infrastructure;
using System;


namespace RieltorHelper.DomainModel
{
    public class UnitOfWork: IDisposable//, IUnitOfWork
    {
        private RieltorDbContext _context;

        private UsersRepository UserRepo;


        public UnitOfWork()
        {
            _context = new RieltorDbContext();
        }
        

        public IRieltorRepository<User> UserRepository
        {
            get
            {
                if (UserRepo == null)
                    UserRepo = new UsersRepository(_context);
                return UserRepo;
            }
            set
            {
                throw new NotImplementedException();
            }
        }

        public void Save()
        {
            _context.SaveChanges();
        }
        
        private bool disposed = false;
 
        public virtual void Dispose(bool disposing)
        {
            if (!this.disposed)
            {
                if (disposing)
                {
                    _context.Dispose();
                }
                this.disposed = true;
            }
        }
    
        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }
    }
}