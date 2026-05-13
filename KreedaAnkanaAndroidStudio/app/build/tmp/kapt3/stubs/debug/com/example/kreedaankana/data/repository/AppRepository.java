package com.example.kreedaankana.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020&J\b\u0010*\u001a\u0004\u0018\u00010+J\b\u0010,\u001a\u0004\u0018\u00010+J\u001e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0086@\u00a2\u0006\u0002\u00100J\u0016\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u00103J\u0016\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u00106J\u000e\u00107\u001a\u00020&H\u0086@\u00a2\u0006\u0002\u00108J\u001e\u00109\u001a\u00020&2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0086@\u00a2\u0006\u0002\u00100J\u001e\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0086@\u00a2\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020&2\u0006\u00105\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u00106J\u0016\u0010@\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010AJ\u0006\u0010B\u001a\u00020&J\u0006\u0010C\u001a\u00020&J\u000e\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020+J\u0006\u0010F\u001a\u00020&J\u000e\u0010G\u001a\u00020&H\u0086@\u00a2\u0006\u0002\u00108R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\t0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0010\u0010$\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/example/kreedaankana/data/repository/AppRepository;", "", "firebase", "Lcom/example/kreedaankana/data/remote/FirebaseRepository;", "scoreDao", "Lcom/example/kreedaankana/data/local/ScoreDao;", "(Lcom/example/kreedaankana/data/remote/FirebaseRepository;Lcom/example/kreedaankana/data/local/ScoreDao;)V", "_bookings", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/kreedaankana/data/model/Booking;", "_challenges", "Lcom/example/kreedaankana/data/model/Challenge;", "_scores", "Lcom/example/kreedaankana/data/model/ScoreMatch;", "_team", "Lcom/example/kreedaankana/data/model/TeamProfile;", "bookingListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "bookings", "Lkotlinx/coroutines/flow/StateFlow;", "getBookings", "()Lkotlinx/coroutines/flow/StateFlow;", "challengeListener", "challenges", "getChallenges", "localScores", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/kreedaankana/data/local/ScoreEntity;", "getLocalScores", "()Lkotlinx/coroutines/flow/Flow;", "scoreListener", "scores", "getScores", "team", "getTeam", "teamListener", "bookSlot", "", "booking", "(Lcom/example/kreedaankana/data/model/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearListeners", "currentEmail", "", "currentUid", "login", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postChallenge", "challenge", "(Lcom/example/kreedaankana/data/model/Challenge;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postScore", "match", "(Lcom/example/kreedaankana/data/model/ScoreMatch;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshLocalScores", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "replyToChallenge", "challengeId", "reply", "Lcom/example/kreedaankana/data/model/Reply;", "(Ljava/lang/String;Lcom/example/kreedaankana/data/model/Reply;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveScoreLocal", "saveTeam", "(Lcom/example/kreedaankana/data/model/TeamProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "startChallengeListener", "startGroundListener", "ground", "startScoreListener", "startUserSync", "app_debug"})
public final class AppRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.kreedaankana.data.remote.FirebaseRepository firebase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.kreedaankana.data.local.ScoreDao scoreDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.kreedaankana.data.model.TeamProfile> _team = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.kreedaankana.data.model.TeamProfile> team = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.kreedaankana.data.model.Booking>> _bookings = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.kreedaankana.data.model.Booking>> bookings = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.kreedaankana.data.model.Challenge>> _challenges = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.kreedaankana.data.model.Challenge>> challenges = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.kreedaankana.data.model.ScoreMatch>> _scores = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.kreedaankana.data.model.ScoreMatch>> scores = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.kreedaankana.data.local.ScoreEntity>> localScores = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.firestore.ListenerRegistration teamListener;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.firestore.ListenerRegistration bookingListener;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.firestore.ListenerRegistration challengeListener;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.firestore.ListenerRegistration scoreListener;
    
    public AppRepository(@org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.remote.FirebaseRepository firebase, @org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.local.ScoreDao scoreDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.kreedaankana.data.model.TeamProfile> getTeam() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.kreedaankana.data.model.Booking>> getBookings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.kreedaankana.data.model.Challenge>> getChallenges() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.kreedaankana.data.model.ScoreMatch>> getScores() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.kreedaankana.data.local.ScoreEntity>> getLocalScores() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String currentUid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String currentEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object register(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void signOut() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startUserSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveTeam(@org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.TeamProfile team, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void startGroundListener(@org.jetbrains.annotations.NotNull()
    java.lang.String ground) {
    }
    
    public final void startChallengeListener() {
    }
    
    public final void startScoreListener() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshLocalScores(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object bookSlot(@org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.Booking booking, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object postChallenge(@org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.Challenge challenge, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object replyToChallenge(@org.jetbrains.annotations.NotNull()
    java.lang.String challengeId, @org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.Reply reply, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object postScore(@org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.ScoreMatch match, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveScoreLocal(@org.jetbrains.annotations.NotNull()
    com.example.kreedaankana.data.model.ScoreMatch match, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void clearListeners() {
    }
}