package Guias.guia4.ej10_CellPhone;

public class FriendCellPhoneBill extends CellPhoneBill {

    private String[] friends;
    private int friendsId;
    private int friendsLimit;
    private double cost;
    private static final double defaultFriendCostPerSecond = 0;

    FriendCellPhoneBill(String number, int limit) {
        super(number);
        this.friendsLimit = limit;
        this.friendsId = 0;
        this.friends = new String[friendsLimit];
        this.cost = defaultFriendCostPerSecond;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addFriend(String friend) throws TooManyFriendsException, AlreadyExistsFriendException{
        if (friendsId == friendsLimit) {
            throw new TooManyFriendsException(friend);
        }
        if(containsFriend(friend)){
            throw new AlreadyExistsFriendException(friend);
        }
        this.friends[friendsId++] = friend;
    }

    private boolean containsFriend(String number) {
        for (int i = 0; i < friendsId; i++) {
            if (friends[i].compareTo(number) == 0) {
                return true;
            }
        }
        return false;
    }

    public void removeFriend(String number) throws FriendNotFoundException{
        boolean found = false;
        for (int i = 0; i < friendsId && !found; i++) {
            if (friends[i].compareTo(number) == 0) {
                friends[i] = friends[--friendsId];    //paso el ultimo a ese lugar
                friendsId--;
                found = true;
            }
        }
        if(!found){
            throw new FriendNotFoundException(number);
        }
    }

    @Override
    public double processBill() {
        double total = 0;
        for (int i = 0; i < callsIndex; i++) {
            boolean friendlyCall = false;
            for (int j = 0; j < friendsId && !friendlyCall; j++) {
                if (calls[i].getTo().compareTo(friends[j]) == 0) {
                    friendlyCall = true;
                }
            }
            total += friendlyCall ? calls[i].getCost() * cost : calls[i].getCost();
        }
        return total;
    }

}

