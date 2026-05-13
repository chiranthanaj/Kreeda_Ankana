package com.example.kreedaankana;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/example/kreedaankana/KreedaApplication;", "Landroid/app/Application;", "()V", "database", "Lcom/example/kreedaankana/data/local/AppDatabase;", "getDatabase", "()Lcom/example/kreedaankana/data/local/AppDatabase;", "database$delegate", "Lkotlin/Lazy;", "firebaseRepository", "Lcom/example/kreedaankana/data/remote/FirebaseRepository;", "getFirebaseRepository", "()Lcom/example/kreedaankana/data/remote/FirebaseRepository;", "firebaseRepository$delegate", "repository", "Lcom/example/kreedaankana/data/repository/AppRepository;", "getRepository", "()Lcom/example/kreedaankana/data/repository/AppRepository;", "repository$delegate", "app_debug"})
public final class KreedaApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy firebaseRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    
    public KreedaApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.kreedaankana.data.local.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.kreedaankana.data.remote.FirebaseRepository getFirebaseRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.kreedaankana.data.repository.AppRepository getRepository() {
        return null;
    }
}