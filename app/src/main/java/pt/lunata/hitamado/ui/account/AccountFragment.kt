package pt.lunata.hitamado.ui.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pt.lunata.hitamado.R
import pt.lunata.hitamado.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_account.*

@AndroidEntryPoint
class AccountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    private val viewModel: AccountViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            viewModel.getDataUser(requireActivity()).observe(requireActivity(), Observer { items ->
                Glide.with(requireContext())
                    .load(items.foto)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_loading)
                    )
                    .into(img_account)
                tv_username_account.text = items.nama
                tv_email_account.text = items.email
                tv_no_telpon_account.text = items.noWa
            })
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Gagal Terhubung ke Internet..", Toast.LENGTH_SHORT)
                .show()
        }
        btn_logout.setOnClickListener {
            val preference = requireContext().getSharedPreferences("APP", Context.MODE_PRIVATE)
            val editor = preference.edit()
            viewModel.doLogout(requireActivity()).observe(requireActivity(), Observer { result->
                if (!result.error!!){
                    editor.clear()
                    editor.apply()
                    val intent = Intent(requireActivity(), LoginActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }else{
                    Toast.makeText(requireActivity(),"Gagal Logout",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}