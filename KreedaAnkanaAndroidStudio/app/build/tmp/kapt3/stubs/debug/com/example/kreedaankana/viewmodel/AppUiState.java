package com.example.kreedaankana.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e\u00a2\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003J\t\u0010+\u001a\u00020\fH\u00c6\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u00c6\u0003J\u0083\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eH\u00c6\u0001J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u000202H\u00d6\u0001J\t\u00103\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00064"}, d2 = {"Lcom/example/kreedaankana/viewmodel/AppUiState;", "", "loggedIn", "", "email", "", "loading", "error", "currentGround", "selectedDate", "Ljava/time/LocalDate;", "team", "Lcom/example/kreedaankana/data/model/TeamProfile;", "bookings", "", "Lcom/example/kreedaankana/data/model/Booking;", "challenges", "Lcom/example/kreedaankana/data/model/Challenge;", "localScores", "Lcom/example/kreedaankana/data/local/ScoreEntity;", "(ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;Lcom/example/kreedaankana/data/model/TeamProfile;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBookings", "()Ljava/util/List;", "getChallenges", "getCurrentGround", "()Ljava/lang/String;", "getEmail", "getError", "getLoading", "()Z", "getLocalScores", "getLoggedIn", "getSelectedDate", "()Ljava/time/LocalDate;", "getTeam", "()Lcom/example/kreedaankana/data/model/TeamProfile;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AppUiState {
    private final boolean loggedIn = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String email = null;
    private final boolean loading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currentGround = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate selectedDate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.kreedaankana.data.model.TeamProfile team = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.kreedaankana.data.model.Booking> bookings = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.kreedaankana.data.model.Challenge> challenges = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.kreedaankana.data.local.ScoreEntity> localScores = null;
    
    public AppUiState(boolean loggedIn, @org.jetbrains.annotations.Nullable()
    java.lang.String email, boolean loading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    java.lang.String currentGround, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate selectedDate, @org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.TeamProfile team, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.kreedaankana.data.model.Booking> bookings, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.kreedaankana.data.model.Challenge> challenges, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.kreedaankana.data.local.ScoreEntity> localScores) {
        super();
    }
    
    public final boolean getLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentGround() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getSelectedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.kreedaankana.data.model.TeamProfile getTeam() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.kreedaankana.data.model.Booking> getBookings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.kreedaankana.data.model.Challenge> getChallenges() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.kreedaankana.data.local.ScoreEntity> getLocalScores() {
        return null;
    }
    
    public AppUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.kreedaankana.data.local.ScoreEntity> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.kreedaankana.data.model.TeamProfile component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.kreedaankana.data.model.Booking> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.kreedaankana.data.model.Challenge> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.kreedaankana.viewmodel.AppUiState copy(boolean loggedIn, @org.jetbrains.annotations.Nullable()
    java.lang.String email, boolean loading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    java.lang.String currentGround, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate selectedDate, @org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.TeamProfile team, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.kreedaankana.data.model.Booking> bookings, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.kreedaankana.data.model.Challenge> challenges, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.kreedaankana.data.local.ScoreEntity> localScores) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}