import Link from "next/link";

export default function Home() {
    return (<div>
        <main>
            <Link href={"./clickables/"}>
                <p>Documentation : <code>Clickable Components</code></p>
            </Link>
        </main>
        <footer>
        </footer>
    </div>)
}
