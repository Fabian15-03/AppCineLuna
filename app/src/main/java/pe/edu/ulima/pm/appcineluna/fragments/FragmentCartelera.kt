package pe.edu.ulima.pm.appcineluna.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.appcineluna.R

class FragmentCartelera:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cartelera,container,false)
    }
}