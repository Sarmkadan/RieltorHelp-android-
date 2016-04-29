using System;

namespace RieltorHelper.DomainModel
{
    public class UnitOfWork: IDisposable
    {
        private RieltorDbContext _context;
        
        /*
        Entity repositories as private fields
        as
        private SomeEntityRepository entityRepo;
        */
        
        public UnitOfWork()
        {
            _context = new RieltorDbContext();
        }

        /*
        Entity repositories as public properties        
        as        
        public SomeEntityRepository EntityRepo
        {
            get
            {
                if (entityRepo == null)
                    entityRepo = new entityRepo(_context);
                return entityRepo;
            }
        }
        */

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