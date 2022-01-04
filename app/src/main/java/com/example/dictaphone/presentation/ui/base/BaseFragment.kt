package com.example.dictaphone.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dictaphone.common.inflate

abstract class BaseFragment : Fragment() {
    abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = container?.inflate(layoutRes)
}