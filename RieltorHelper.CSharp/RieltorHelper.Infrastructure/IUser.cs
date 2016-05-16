using System.Runtime.Serialization;

namespace RieltorHelper.Infrastructure
{
    public interface IUser
    {
        string About { get; set; }
        string FIO { get; set; }
        int Id { get; set; }
        int Phone { get; set; }
    }
}