package com.project.relaxinn.domain.base

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<in P, out R> {
    operator fun invoke(params: P): Flow<Result<R>>
}
