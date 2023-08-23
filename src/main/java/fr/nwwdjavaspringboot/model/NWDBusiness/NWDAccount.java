package fr.nwwdjavaspringboot.model.NWDBusiness;

public class NWDAccount extends NWDBasicModel implements INWDAccountRange{

    public int Range;
    public Boolean Ban = false;
    /// <summary>
    /// if trashed ... account will be deleted  at this Timestamp
    /// </summary>
    public int WillBeDeleteAtTimestamp;
    /// <summary>
    /// if Migration ... Its data change server ... come back later
    /// </summary>
    public Boolean Migration = false;
    /// <summary>
    /// Use to add message for this account (less than 256 char)
    /// </summary>
    public String Message;

    public String Payload;

    /*
    static public int ExtractRange(long sReference)
    {
        int rReturn = Integer.parseInt(sReference.ToString().Substring(1, NWDConstants.K_REFERENCE_AREA_GLOBAL.ToString().Length - NWDConstants.K_REFERENCE_AREA_RANGE.ToString().Length));
        return rReturn;
    }

    public Boolean Equals(object? obj)
    {
        return Reference == (obj as NWDAccount)?.Reference;
    }

    public int GetHashCode()
    {
        return Reference.GetHashCode();
    }
     */
}
