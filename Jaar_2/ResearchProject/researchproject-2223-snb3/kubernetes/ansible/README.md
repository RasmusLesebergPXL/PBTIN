## Typical steps to setup

1. Run main playbook
2. Apply CNI manually on main controller
4. Manually add nodes with weird fix
6. Apply CNI manually again to make nodes ready


Fix for 6443 connection refused on masterC
```
    sudo -i
    swapoff -a
    exit
    strace -eopenat kubectl version
```

Fix for join
```
    sudo kubeadm reset
    sudo systemctl enable docker
    sudo systemctl enable kubelet
    sudo systemctl daemon-reload
    sudo kubeadm join <token>
```

To delete run delete_k8.yml

https://kubernetes.io/blog/2019/03/15/kubernetes-setup-using-ansible-and-vagrant/
https://microservices-demo.github.io/deployment/kubernetes-start.html
https://docs.cilium.io/en/stable/gettingstarted/k8s-install-default/
