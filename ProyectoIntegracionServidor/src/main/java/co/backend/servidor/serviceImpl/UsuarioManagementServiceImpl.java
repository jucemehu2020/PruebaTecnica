package co.backend.servidor.serviceImpl;

import co.backend.servidor.dto.UsuarioDTO;
import co.backend.servidor.firebase.FirebaseInitializer;
import co.backend.servidor.service.UsuarioManagamentService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julio
 */
@Service
public class UsuarioManagementServiceImpl implements UsuarioManagamentService {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public String buscarCursosMatriculados() {
       
        return "Hola";
    }
    
    private Map<String, Object> getDocData(UsuarioDTO usuario) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("idUsuario", usuario.getIdUsuario());
        docData.put("correo", usuario.getCorreo());
        docData.put("rol", usuario.getRol());
        docData.put("nombre_completo", usuario.getNombre_completo());
        docData.put("estado", usuario.getEstado());
        return docData;
    }


    @Override
    public List<UsuarioDTO> list() {

        List<UsuarioDTO> response = new ArrayList<>();
        UsuarioDTO usuario;

        //ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection("usuario").get();
        Query query = firebase.getFirestore().collection("usuario").whereEqualTo("rol", "Docente");
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = query.get();

        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                usuario = doc.toObject(UsuarioDTO.class);
                usuario.setId(doc.getId());
                response.add(usuario);
            }
            return response;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UsuarioDTO listById(String id) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public Boolean add(UsuarioDTO usuario) {
        return true;
    }

    @Override
    public Boolean edit(String id, UsuarioDTO usuario) {
        return true;
    }

    @Override
    public Boolean delete(String id) {
        return true;
    }

}
