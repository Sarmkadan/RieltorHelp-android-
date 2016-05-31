using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace RieltorHelper.DomainModel
{
    public interface IGenericRepository<T> where T: class
    {
        int GetCount();
        Task<int> GetCountAsync();
        IQueryable<T> Get();
        Task<IQueryable<T>> GetAsync();
        IQueryable<T> Get(Expression<Func<T, bool>> query);
        Task<IQueryable<T>> GetAsync(Expression<Func<T, bool>> query);
        T Get(int id);
        Task<T> GetAsync(int id);
        void Create(T value);
        Task CreateAsync(T value);
        void Edit(int id, T value);
        Task EditAsync(int id, T value);
        void Delete(int id);
        Task DeleteAsync(int id);
    }
}
