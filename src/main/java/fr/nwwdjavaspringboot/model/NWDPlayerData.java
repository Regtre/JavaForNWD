package fr.nwwdjavaspringboot.model;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDBasicModel;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDPlayerDataProcessKind;

import java.math.BigInteger;

public abstract class NWDPlayerData extends NWDBasicModel {

    public BigInteger Account ;
    public int Range ;
    public int DataTrack ;
    public boolean AvailableForWeb  = false;
    public boolean AvailableForGame  = false;
    public boolean AvailableForApp  = false;
    public int SyncDatetime ;
    public int Commit ;
    public NWDPlayerDataProcessKind Process  = NWDPlayerDataProcessKind.None;
}
