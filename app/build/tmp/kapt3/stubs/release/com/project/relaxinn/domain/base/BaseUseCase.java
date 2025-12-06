package com.project.relaxinn.domain.base;

import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\"\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u00a6\u0002\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/project/relaxinn/domain/base/BaseUseCase;", "P", "R", "", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "params", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "app_release"})
public abstract interface BaseUseCase<P extends java.lang.Object, R extends java.lang.Object> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<kotlin.Result<R>> invoke(P params);
}